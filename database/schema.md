

# Tables 

## Users

CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL DEFAULT 'customer'
);


## Itesm

CREATE TABLE items (
    id INTEGER PRIMARY KEY AUTOINCREMENT, 
    name TEXT NOT NULL,
    quantity INTEGER NOT NULL DEFAULT 0,
    price REAL NOT NULL,
    picture_uri TEXT,
    rating REAL NOT NULL
);


## orders

CREATE TABLE orders (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    buyer_id INTEGER NOT NULL,
    order_date TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total_amount REAL NOT NULL DEFAULT 0.0,
    FOREIGN KEY (buyer_id) REFERENCES users(id)
);

## order_item

CREATE TABLE order_items (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    order_id INTEGER NOT NULL,
    item_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL DEFAULT 1,
    price REAL NOT NULL DEFAULT 0.0,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (item_id) REFERENCES items(id)
);
