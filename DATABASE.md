# Database schema overview

Hibernate creates and updates the schema from the JPA model (`spring.jpa.hibernate.ddl-auto=update`). The model is intentionally normalized around these relationships:

```text
users 1---* leads
users 1---* customers
users 1---* bookings
customers 1---* bookings *---1 properties
customers 1---* payments
customers 1---* loans
customers 1---* documents
customers 1---* support_ticket
leads 1---* follow_up
leads 1---* site_visit *---1 properties
```

The remaining operational tables (`employee`, `vendor`, `petty_cash`, and `account`) share audit columns through `BaseEntity`: generated ID, created timestamp, updated timestamp, and a soft-delete flag. A MySQL-compatible configuration is provided in `application-mysql.properties`.
