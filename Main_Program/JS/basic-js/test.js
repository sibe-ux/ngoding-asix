const { google } = require("googleapis");
const fs = require("fs");
const path = require("path");

// Replace with your API key
const API_KEY = "AIzaSyCxkdo7DDaO7-QiIxQjGtoTfWo39VwNu-M";

// Replace with the ID of your folder
const FOLDER_ID = "1ly21Hh96aDIqLAUJbK4EkRywqdLIBdAS";

// Replace with the path to your credentials.json
const CREDENTIALS_PATH = "path/to/your/credentials.json";

// Load credentials
const credentials = JSON.parse(fs.readFileSync(CREDENTIALS_PATH));

// Create a new JWT client
const auth = new google.auth.JWT({
	email: credentials.client_email,
	key: credentials.private_key,
	scopes: ["https://www.googleapis.com/auth/drive.readonly"],
});

const drive = google.drive({ version: "v3", auth });

// Utility function to generate random duration
function generateRandomDuration() {
	const durationSeconds = 30 + Math.floor(Math.random() * 271); // Between 30 and 300 seconds
	const minutes = Math.floor(durationSeconds / 60);
	const seconds = durationSeconds % 60;
	return `${String(minutes).padStart(2, "0")}:${String(seconds).padStart(
		2,
		"0"
	)}`;
}

// Escape single quotes in SQL strings
function escapeSqlString(value) {
	return value.replace(/'/g, "''");
}

async function listFilesInFolder() {
	try {
		const res = await drive.files.list({
			q: `'${FOLDER_ID}' in parents`,
			fields: "files(id, name)",
		});

		const files = res.data.files;

		if (!files || files.length === 0) {
			console.log("No files found.");
			return;
		}

		const baseTime = new Date();

		const category = "2";
		const artist = "Hikaru Nanase";
		const album = "Kyoukai no Kanata I'LL BE HERE ~Original Soundtrack~ Disc 1";
		const coverLink =
			"https://drive.google.com/file/d/1AWGXOwghRqP6mjyiC0fmQejfzCeHQENO/view?usp=drive_link";
		const favorite = "0";

		const values = files.map((file, index) => {
			const fileNameWithoutExtension = path.parse(file.name).name;
			const fileId = file.id;
			const linkGDrive = `https://drive.google.com/file/d/${fileId}/view?usp=drive_link`;
			const dateAdded = new Date(baseTime.getTime() + index * 1000);
			const dateAddedStr = dateAdded
				.toISOString()
				.slice(0, 19)
				.replace("T", " ");

			const duration = generateRandomDuration();

			return `(
        NULL, 
        '${category}', 
        '${escapeSqlString(linkGDrive)}', 
        '${escapeSqlString(fileNameWithoutExtension)}', 
        '${escapeSqlString(artist)}', 
        '${escapeSqlString(album)}', 
        '${escapeSqlString(duration)}', 
        '${escapeSqlString(coverLink)}', 
        '${favorite}', 
        '${escapeSqlString(dateAddedStr)}'
      )`;
		});

		const insertStatement = `
      INSERT INTO music (id_music, category, link_gdrive, title, artist, album, time, cover, favorite, date_added) 
      VALUES 
      ${values.join(",\n")}
      ;
    `;

		console.log(insertStatement);
	} catch (error) {
		console.error(`An error occurred: ${error}`);
	}
}

listFilesInFolder();
