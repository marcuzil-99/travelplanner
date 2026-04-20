CREATE TABLE notifications (
    id BIGSERIAL PRIMARY KEY,
    customer_email VARCHAR(50) NOT NULL,
    subject VARCHAR(50) NOT NULL,
    content VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL
);