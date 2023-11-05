/* Creamos algunos usuarios con sus roles */
INSERT INTO users (username, password, state) VALUES ('andres','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',true);
INSERT INTO users (username, password, state) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',true);

INSERT INTO role_users (user_id, name) VALUES (1,'ROLE_USER');
INSERT INTO role_users (user_id, name) VALUES (2,'ROLE_ADMIN');
INSERT INTO role_users (user_id, name) VALUES (2,'ROLE_USER');