# L10 – Database migrations med Spring Boot och Flyway

Detta är ett litet undervisningsprojekt för Java 21, Maven, Spring Boot 4.1.2, PostgreSQL 16 och Flyway.

Projektet börjar med EN enda migration (V1). Under lektionen kopierar läraren in V2 och ändrar därefter JPA-entiteten. 
På så sätt syns skillnaden mellan en redan applicerad migration och en ny migration som väntar på att köras.

## Innehåll

- `pom.xml` – Spring Boot, Spring Data JPA, Flyway och PostgreSQL.
- `docker-compose.yml` – lokal PostgreSQL på port 5435.
- `.env.example` – lokala anslutningsinställningar.
- `src/main/resources/application.properties` – DataSource, Flyway och Hibernate validate.
- `src/main/resources/db/migration/V1__create_pokemon_table.sql` – första databasschemat och startdata.
- `src/main/resources/db/migration/V2__add_nickname.sql` – nästa migration att kopiera in under lektionen.
- `classroom-steps/Pokemon_v2.java.txt` – kodsnutt för den utökade entiteten.
- `exercises/V3__create_battle_statistics.sql.txt` – migrationsövning.

## Förberedelser
1. Starta Docker Desktop.
2. Byt namn på .env.example till .env
3. PowerShell:
docker compose up -d
docker compose ps

## Övning – MIGRATION V3

Utgå från `exercises/V3__create_battle_statistics.sql.txt`.

- Kopiera den till `src/main/resources/db/migration/`.
- Döp om till `V3__create_battle_statistics.sql`.
- Kör applikationen.
- Kontrollera med DBeaver att tabellen `battle_statistics` skapats och att V3 syns i `flyway_schema_history`.

## Ta med er detta från lektionen

- Flyway-versionerade migrationer är små, numrerade ändringar som appliceras i versionsordning.
- `flyway_schema_history` visar vilka migrationer som körts och innehåller bland annat checksummor.
- Ändra inte en versionsmigration som redan har applicerats i en delad miljö. Skapa en ny migration i stället.
- Flyway hanterar schemaändringarna. Hibernate är satt till `validate` och ska inte skapa eller uppdatera schemat.
- Migrationer kan innehålla både DDL (t.ex. CREATE/ALTER) och DML (t.ex. UPDATE/INSERT).
- Flyway ersätter inte backup, testning eller granskning av riskfyllda ändringar.
- Använd inte `clean` mot en produktionsdatabas. Kommandot kan ta bort alla objekt i konfigurerade scheman.

## Om du vill återställa demoläget

`docker compose down` stoppar containern men behåller datavolymen och Flyway-historiken.

För att radera ENDAST denna L10-databas och starta från tomt läge:

```powershell
docker compose down -v
docker compose up -d
```

Varning: `down -v` raderar all data i L10-projektets volym. Kör bara när du medvetet vill börja om.

## Befintlig databas – viktigt

Det här demoprojektet utgår från en tom databas. Om en applikation redan har ett schema och data ska man inte köra V1 blint; den kan försöka skapa objekt som redan finns. 
Ett befintligt schema behöver först inventeras och jämföras med den avsedda baslinjen. Därefter kan Flyway börja följa kommande ändringar från en avstämd baseline-version. 
Aktivera inte automatisk baseline utan att förstå vilken databas som påverkas.

