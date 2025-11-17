CREATE TABLE sessions (
    session_id VARCHAR(32) NOT NULL,
    user_id VARCHAR(26) NOT NULL,
    session_token VARCHAR(100) NOT NULL,
    expire_at bigint NOT NULL,
    deleted_at boolean DEFAULT FALSE,
    created_at bigint NOT NULL,
    updated_at bigint NOT NULL,
    created_by VARCHAR(26) NOT NULL,
    updated_by VARCHAR(26) NOT NULL,
    CONSTRAINT sessions_pk PRIMARY KEY (session_id)
);

CREATE TABLE departments (
    department_id VARCHAR(32) NOT NULL,
    department_name VARCHAR(100) NOT NULL,
    department_code VARCHAR(100) NOT NULL,
    deleted_at boolean DEFAULT FALSE,
    created_at bigint NOT NULL,
    updated_at bigint NOT NULL,
    created_by VARCHAR(26) NOT NULL,
    updated_by VARCHAR(26) NOT NULL,
    CONSTRAINT departments_pk PRIMARY KEY (department_id)
);
CREATE INDEX departments_department_id_department_code ON departments (department_id, department_code);

CREATE TABLE designations (
    designation_id VARCHAR(32) NOT NULL,
    designation_name VARCHAR(100) NOT NULL,
    designation_code VARCHAR(100) NOT NULL,
    deleted_at boolean DEFAULT FALSE,
    created_at bigint NOT NULL,
    updated_at bigint NOT NULL,
    created_by VARCHAR(26) NOT NULL,
    updated_by VARCHAR(26) NOT NULL,
    CONSTRAINT designations_pk PRIMARY KEY (designation_id)
);
CREATE INDEX designations_designation_id_department_code ON designations (designation_id, designation_code);

CREATE TABLE users (
    user_id VARCHAR(32) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL,
    country_code VARCHAR(5) NOT NULL,
    contact_number VARCHAR(10) NOT NULL,
    department_id VARCHAR(26) NOT NULL,
    designation_id VARCHAR(26) NOT NULL,
    user_status boolean DEFAULT FALSE,
    deleted_at boolean DEFAULT FALSE,
    created_at bigint NOT NULL,
    updated_at bigint NOT NULL,
    created_by VARCHAR(26) NOT NULL,
    updated_by VARCHAR(26) NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (user_id),
    CONSTRAINT users_department_id_fk FOREIGN KEY (department_id)
    REFERENCES departments (department_id),
    CONSTRAINT users_designation_id_fk FOREIGN KEY (designation_id)
        REFERENCES designations (designation_id)
);
CREATE INDEX users_user_id_email ON users (user_id, email);
CREATE INDEX users_user_id_username ON users (user_id, username);


CREATE TABLE leave_types (
    leave_type_id VARCHAR(32) NOT NULL,
    leave_type_name VARCHAR(100) NOT NULL,
    leave_type_code VARCHAR(100) NOT NULL,
    deleted_at boolean DEFAULT FALSE,
    created_at bigint NOT NULL,
    updated_at bigint NOT NULL,
    created_by VARCHAR(26) NOT NULL,
    updated_by VARCHAR(26) NOT NULL,
    CONSTRAINT leave_types_pk PRIMARY KEY (leave_type_id)
);
CREATE INDEX leave_types_leave_type_id_leave_type_code ON leave_types (leave_type_id, leave_type_code);

CREATE TABLE leaves (
    leave_id VARCHAR(32) NOT NULL,
    user_id VARCHAR(26) NOT NULL,
    leave_type_id VARCHAR(26) NOT NULL,
    from_date bigint NOT NULL,
    to_date bigint NOT NULL,
    number_of_days int NOT NULL,
    leave_reason VARCHAR(200) NOT NULL,
    reported_to_id VARCHAR(26) NOT NULL,
    leave_status VARCHAR(20) NOT NULL,
    deleted_at boolean DEFAULT FALSE,
    created_at VARCHAR(26) NOT NULL,
    updated_at varchar(26) NOT NULL,
    created_by bigint NOT NULL,
    updated_by bigint NOT NULL,
    CONSTRAINT leaves_pk PRIMARY KEY (leave_id)
);


CREATE TABLE leave_history (
    leave_history_id VARCHAR(32) NOT NULL,
    user_id VARCHAR(26) NOT NULL,
    status VARCHAR(20) NOT NULL,
    deleted_at boolean DEFAULT FALSE,
    created_at bigint NOT NULL,
    updated_at bigint NOT NULL,
    created_by VARCHAR(26) NOT NULL,
    updated_by VARCHAR(26) NOT NULL,
    CONSTRAINT leave_history_pk PRIMARY KEY (leave_history_id)
);
