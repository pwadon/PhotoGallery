# Photo Gallery Project
baza danych mysql

Uruchomienie:
1. Po sklonowaniu z githuba i podłączeniu do bazy danych należy uruchomić skrypt schema.sql (znajdujący się w folferze resources) aby zainicjować odpowienią bazę o nazwie photogallery oraz tabele.
2. W pliku application.properties należy ustawić odpowiednie parametry logowania do bazy danych
3. Uruchomić clean i package w mavenie
4. Uruchomić aplikację przez wlączenie pliku PhotoGalleryApplications w folderze src/main/java/project/photoGallery
5. Podczas uruchomiena aplikacji, do bazy zostanie dodanych 3 użytkowników (admin - hasło: admin, piotrek - hasło: piotrek, andrzej -hasło: andrzej)
6. Wpisujemy w przeglądarce adres http://localhost:8080/photogallery, logujemy się na admina przy pomocy hasła admin i klikamy ADMIN PANEL aby dodać użytkowników, dodać galerie lub dodać zdjęcia. Użytkownicy piotrek oraz andrzej mają po zalogowaniu dostęp tylko do widoku swoich galerii.
7. Po dodaniu zdjęć do wybranych galerii użytkownicy będą mieli możliwość przeglądania tych zdjęć po zalogowaniu do aplikacji.
