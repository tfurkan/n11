Docker local sisteme kurulmalıdır.
https://github.com/SeleniumHQ/docker-selenium reposunda yer alan docker-compose-v2.yml dosyası locale alınmalıdır.
docker-compose -f /path/to/docker-compose.yml up -d komutu docker-compose.yml dosyasının yer aldığı yol verilerek çalıştırılmalıdır.
Aynı networkte yer alan nodelar create edilmiş olur. 
docker-compose up ile ayağa kaldırılır.
Docker Desktep uygulamasından ya da http://localhost:4444/wd/hub arayüzünden ayakta olan nodelar görüntülenebilir.
TestNG.xml dosyasından ilgili parallel test türü belirlenir
