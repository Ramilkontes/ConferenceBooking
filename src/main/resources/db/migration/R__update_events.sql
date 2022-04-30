UPDATE events
SET status = 'ACTIVE'
WHERE DATE(date_start)= CURRENT_DATE
    OR DATE(date_finish) = CURRENT_DATE;

UPDATE events
SET status = 'CLOSED'
WHERE DATE(date_start) < CURRENT_DATE;