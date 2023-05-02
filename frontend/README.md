# FRONTEND dokumentatsioon 

## LOGIN INFO 
Andmebaasi on loodud 3 kasutajat. Nendeks on:
1.
*username = root
*password = root

2. 
*username = root1
*password = root1

3.
*username = root2
*password = root2

Kasutajad loodi eesmärgil näidata, et kasutajad ei näe teiste kasutajate poolt lisatud loomasid. Route'd on protected; ainult sisselogitud kasutajad saavad vaadata ja lisada lemmikloomi.

Sisselogimisel kontrollitakse kas leidub kasutaja selle username ja password-ga. Kui leidub, lisatakse sessionStorage-ga kasutaja id ja kasutajanimi.
Väljalogimisel esmalt kustutakse sessioonis olevad andmed ning saadetakse tagasi sisselogimise lehele.

## Ülevaade

Kasutajale kuvatakse list kasutaja enda loomadest (Kui tal need on). Loomi saab juurde lisada vajutades nupule "Add new". Kõiki loomi saab sorteerida mistahes tunnusele (loomad sorteeritakse 1. Tähetikulises järjekorras või 2. numbrilises järjekorras).
Igale loomale on tema alla lisatud edit ja delete nupp (aka looma tunnuseid saab muuta ning loomi saab kustutada).

Uue looma lisamisel tuleb lisada talle nimi, tüüp, värv ja päritoluriik. Kõik vormi väljad peale nime kuvatakse kasutajale select listi optionite kujul, mille andmed tulevad andmebaasist. Looma koodi sisestamine jääb backendi teha, kus genereeritakse talle isiklik UUID. Vormile tehakse frontendis kontroll(kas on andmed sisestatud, kas need on tühjad või mitte jne).

Loomade lisamiseks, muutmiseks ja kustutamiseks ei suunata neid uuele lehele, vaid avatakse modal, kus kasutaja saab vastavaid tegevusi teha. Leidsin, et modalite kasutaminne on mugavam kui uuele lehele suunamine ning näeb ka parem välja.

Kui kasutaja proovib liikuda veebilehele, mida pole olemas(näiteks: localhost:####/asdasd), siis kuvatakse talle pagenotfound lehekülg.

CSS-i ja HTML template-id pole loodud minu poolt, vaid võetud bootdev lehelt.
