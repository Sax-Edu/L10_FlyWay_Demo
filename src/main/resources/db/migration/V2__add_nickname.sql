-- Körs först efter att V1 har applicerats.

ALTER TABLE pokemon
    ADD COLUMN nickname VARCHAR(100);

-- Befintliga rader får ett värde innan kolumnen blir NOT NULL.
UPDATE pokemon
SET nickname = name
WHERE nickname IS NULL;

ALTER TABLE pokemon
    ALTER COLUMN nickname SET NOT NULL;
