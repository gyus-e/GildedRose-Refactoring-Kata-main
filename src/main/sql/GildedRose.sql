DROP TABLE IF EXISTS Items;

CREATE TABLE IF NOT EXISTS Items
(
    name
    VARCHAR,
    sellIn
    INT,
    quality
    INT,
    id
    VARCHAR
    PRIMARY
    KEY
);

CREATE VIEW IF NOT EXISTS mainView AS
SELECT name, sellIn, quality
FROM Items;

CREATE TRIGGER IF NOT EXISTS delete_no_value_items
	AFTER
UPDATE OF quality
ON Items
    WHEN NEW.quality=0
BEGIN
DELETE
FROM Items
WHERE OLD.id = id;
END;

DELETE
FROM Items;
