<?php
require 'vendor/autoload.php';

use Google\Client;
use Google\Service\Drive;

// Initialize Google Client
$client = new Client();
$client->setAuthConfig('data.json'); // Replace with the path to your credentials file
$client->addScope(Drive::DRIVE_READONLY);
$client->setAccessType('offline');

// Create the Drive service
$service = new Drive($client);

// Folder ID of the Google Drive folder
$folderId = '1U7Xqb7x2BeDrwTFGQbI_iw6gwzb3BIB1'; // Replace with your folder ID

// Fetch the list of files in the folder
$results = $service->files->listFiles(array(
    'q' => "'" . $folderId . "' in parents",
    'fields' => 'files(id, name, webViewLink)',
    'pageSize' => 1000 // Adjust as needed
));

// Store file details in an array
$files = array();
foreach ($results->files as $file) {
    $files[] = array(
        'name' => $file->name,
        'link' => $file->webViewLink
    );
}

// Output the file details
foreach ($files as $file) {
    echo "Name: " . $file['name'] . "<br>";
    echo "Link: <a href='" . $file['link'] . "'>" . $file['link'] . "</a><br><br>";
}