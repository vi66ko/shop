

# Tables 

## Users

```SQL
CREATE TABLE user (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    address TEXT,
    phone_number TEXT
);
```
## Session

```SQL
CREATE TABLE session (
    sessionID TEXT PRIMARY KEY,
    userID INTEGER NOT NULL,
    created_at TEXT DEFAULT CURRENT_TIMESTAMP,
    expires_at TEXT NOT NULL,
    is_active INTEGER DEFAULT 1,
    FOREIGN KEY (userID) REFERENCES user(id)
);
```

## Items

```SQL
CREATE TABLE item (
    id INTEGER PRIMARY KEY AUTOINCREMENT, 
    name TEXT NOT NULL,
    description TEXT,
    quantity INTEGER NOT NULL,
    price REAL NOT NULL,
    picture_uri TEXT,
    category TEXT,
    date_created TEXT DEFAULT CURRENT_TIMESTAMP,
    seller_id INTEGER,
    rating INTEGER,
    FOREIGN KEY (seller_id) REFERENCES user(id)
);
```


## Review

```SQL
CREATE TABLE review (
    review_id INTEGER PRIMARY KEY AUTOINCREMENT,
    item_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    rating INTEGER CHECK(rating >= 1 AND rating <= 5),
    comment TEXT,
    date_created TEXT DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (item_id) REFERENCES item(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);
```


## orders

```SQL
CREATE TABLE "order" (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    orderDate TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total_amount REAL NOT NULL DEFAULT 0.0,
    FOREIGN KEY (userID) REFERENCES user(id)
);
```

## order_item

```SQL
CREATE TABLE order_item (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    item_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL DEFAULT 1,
    price REAL NOT NULL DEFAULT 0.0,
    FOREIGN KEY (order_id) REFERENCES "order"(id),
    FOREIGN KEY (item_id) REFERENCES item(id)
);
```


## Basket items

```SQL
CREATE TABLE basket_item (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    item_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    date_added TEXT DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (item_id) REFERENCES item(id)
);

```
