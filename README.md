# EstateFlow Real Estate CRM

EstateFlow is a Spring Boot 3 / Java 17 real-estate operations CRM with sales, customer, finance, vendor, HR, document, and support workflows.

## Run locally

Requirements: Java 17+ and Maven 3.9+.

```bash
mvn spring-boot:run
```

The default profile uses a file-backed H2 database so the application is immediately runnable. The schema is created by Hibernate and demo records are inserted on the first run.

Open `http://localhost:8080/login`.

To use MySQL instead:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=mysql
```

Set `CRM_DB_USERNAME` and `CRM_DB_PASSWORD` for the database credentials. The MySQL profile creates the `realestatecrm` database when the server user has permission to do so.

## Demo accounts

| Username | Password | Role |
| --- | --- | --- |
| admin | admin123 | Full system access |
| sales1 | sales123 | Sales and customer workflows |
| accounts1 | accounts123 | Finance, loans, vendors, petty cash |
| hr1 | hr123 | Employee operations |
| manager1 | manager123 | Reporting and approvals |

## Included workflows

- Role-specific dashboards, sidebar navigation, server-side authorization, and access-denied routing
- Lead qualification, follow-ups, properties, site visits, customers, negotiations represented through booking approval, bookings, documents, loans, payments, support tickets, employees, vendors, petty cash, accounts, and finance metrics
- CRUD-style create flows with soft-delete archive actions for sales records
- Searchable responsive tables, modal forms, validation, toast feedback, CSV lead export, file upload, document verification state, charts, dark mode, and mobile navigation
- Hibernate/JPA normalized relationships across users, leads, customers, properties, bookings, payments, loans, documents, employees, vendors, and finance records

## Project layout

`config` contains security and demo seed configuration. `controller`, `service`, `serviceImpl`, `repository`, `entity`, and `security` are separated by responsibility. Templates are under `src/main/resources/templates`; presentation assets are under `src/main/resources/static`.

For production, set a strong database password, use an external file store for uploads, terminate TLS at the reverse proxy, and replace the demo seed credentials.
