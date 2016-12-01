Sunt implementate inregistrarea utilizatorului (contine doar parola), login, introducerea unei carti, cautarea de carti.

Programul foloseste json-simple-1.1.1.jar. 
Se obtine de la https://code.google.com/archive/p/json-simple/downloads 
Se va adauga in Eclipse prin Project->Properties->Java Build Path->Libraries->Add External JARs

Parola utilizatorului este un intreg. Se poate ca programul final sa accepte si string, care sa fie convertite de javascript la intreg. Intregul va trebui sa fie < 2^26 (patratul sau trebuie sa incapa in 2^53 - 1 cat este maximul pt javascript)
Parola va fi trimisa codificat. Pentru codificare, se va accesa functia get_public_key(), care va intoarce cheia publica. Se va apela apoi get_for_modulo(). Se va trimite parola ^ get_public_key() % get_for_modulo(). Atentie, ridicarea la putere trebuie sa tina seama de modul si sa nu se faca depasirea max_long.

username-ul si parola vor fi trimise odata cu fiecare operatie de trimitere a unei carti (javascript poate stoca unername-ul si parola pentru a nu le solicita din nou). Cautarea nu necesita logarea. Utilizatorii sunt memorati in fisiere in directorul utilizatori.

Functia introduce_book va suprascrie cartea respectiva daca exista deja (o carte este unic determinata de categorie, oras, utilizator si titlu).

Functia get_books va cauta cartile dupa urmatoarele field-uri : 
	username, category, city, autor, title.
	Daca un field are valoarea null, cautarea nu va include acel field. (se poate introduce si string-ul vid in loc de null)
	Cautarea este liniara. Daca se cauta doar dupa titlu, se vor parcurge toate cartile.
	Va fi returnat un obiect JSON
