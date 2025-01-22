--SCHEMA PARA MICROSERVICIO ACCOUNT
CREATE SCHEMA IF NOT EXISTS ACCOUNT;

--TABLAS PARA  SCHEMA account
CREATE TABLE IF NOT EXISTS account.movement (
    movement_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_id BIGINT NOT NULL,
    balance DECIMAL(19, 2) NOT NULL,
    created_by_user VARCHAR(255),
    created_date TIMESTAMP,
    created_from_ip VARCHAR(50),
    last_modified_by_user VARCHAR(255),
    last_modified_date TIMESTAMP,
    movement_date TIMESTAMP,
    movement_type VARCHAR(50),
    status VARCHAR(20),
    updated_from_ip VARCHAR(50),
    transaction_value DECIMAL(19, 2)
);