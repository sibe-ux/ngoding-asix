import requests

# Ganti dengan informasi Anda
token = 'your token'
repo_owner = 'sibeux'
repo_name = 'expert-goggles'
file_path = 'Akame ga Kill! Original Soundtrack Vol.1/Disc 1/A Recruit`s Wish.flac'

# URL API GitHub
url = f'https://api.github.com/repos/{repo_owner}/{repo_name}/contents/{file_path}'

headers = {
    'Authorization': f'token {token}',
    'Accept': 'application/vnd.github.v3.raw',
}

# Mengambil file
response = requests.get(url, headers=headers)
if response.status_code == 200:
    with open('media.file', 'wb') as f:
        f.write(response.content)
    print("File downloaded successfully!")
else:
    print("Failed to download the file:", response.status_code)
