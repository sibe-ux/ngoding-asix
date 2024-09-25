import requests

# Token bot dan ID file
bot_token = '6654344279:AAFnYXl2uVcfAAQifdi8Xz9XY7h3zqsPPDA'
file_id = 'CQACAgUAAxkBAAMEZs4ERDOxj5qSlEPLCm4MTAUxm0kAAioRAAKkRHBW1CK0fRQjI1M1BA'

# Dapatkan path file
get_file_url = f"https://api.telegram.org/bot{bot_token}/getFile?file_id={file_id}"
response = requests.get(get_file_url)
file_info = response.json()

if response.status_code == 200 and file_info['ok']:
    file_path = file_info['result']['file_path']
    download_url = f"https://api.telegram.org/file/bot{bot_token}/{file_path}"
    
    print(f"URL Unduhan: {download_url}")
else:
    print("Gagal mendapatkan informasi file.")
    print("Response JSON:", file_info)
