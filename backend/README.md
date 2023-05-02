# Backend dokumentatsioon

## Ülevaade

Projekti saab jagada neljaks peamiseks kategooriaks, mis vastutavad backendi töö eest:
1. models
2. repos
3. services
4. resources

Modelid vastutavad vastavate Entity-de loomise eest. Nendeks on accounts, colors, origins, pets ja types. Need loovad andmebaasi objektid, kuhu hakkame andmeid salvestama.

Repod vastutavad teatud SQL päringute loomise eest. Extendivad JpaRepository-t.

Service-id vastutavad sql päringute käivitamise ning andmete tagastamise eest.

Resorce-des defineerime vastavad requestid RestControllerile. Näiteks PetsResource-i all defineerime mappingu "/pets"-le, mille alla lisame vastavad RESTi mappingud:
* GetMapping ("/all" ja "/find/{id})
* PostMapping ("/add")
* PutMapping ("/update")
* DeleteMapping ("/delete/{id}")

PetManagementApplication on siis see main programm, mille käivitamisel käivitatakse backend. Sinna pidin lisama CorsFilteri, kuna muidu ei saa me mingied requeste saata frontendist backendi, kuna muidu hakkab CORS policy meile ebameeldivusi tekitama. 
