# TP SOA – Services web REST et SOAP avec Spring Boot

Trois projets Maven (Spring Boot 2.7.18, Java 8), développés sous Eclipse.
Le compte rendu se trouve dans `Compte_rendu_TP_SOA.docx`.

| Projet | Type | Port |
|---|---|---|
| `currency-exchange-service` | Microservice REST (H2 en mémoire) | 8000 |
| `employee` | API REST CRUD (MySQL) | 8080 |
| `spring-boot-soap-service` | Service web SOAP (Spring-WS) | 8080 |

## Prérequis

- JDK 8 (ou plus récent)
- MySQL pour `employee` : utilisateur `root` sans mot de passe par défaut
  (modifiable dans `employee/src/main/resources/application.properties`).
  La base `employee-schema` et la table `employee` sont créées automatiquement.

## Lancer un projet

Dans Eclipse : *File > Import > Existing Maven Projects*, puis *Run As > Java Application* sur la classe `*Application`.

En ligne de commande :

```bash
cd employee
./mvnw spring-boot:run      # mvnw.cmd sous Windows
```

`employee` et `spring-boot-soap-service` utilisent tous les deux le port 8080 : les lancer l'un après l'autre.

## Tester

**TP1 – Currency Exchange**

```
GET http://localhost:8000/currency-exchange-sample/fromCurrency/USD/toCurrency/INR
```

**TP2 – Employee**

```bash
curl -X POST -H "Content-Type: application/json" \
     -d '{"firstName":"Ali","lastName":"Ben Salah","emailId":"ali@mail.com"}' \
     http://localhost:8080/api/employees
curl http://localhost:8080/api/employees
```

Endpoints : `POST /api/employees`, `GET /api/employees`, `PUT /api/employees/{id}`, `DELETE /api/employees/{id}`.

**TP3 – SOAP Student**

- WSDL : http://localhost:8080/service/studentDetailsWsdl.wsdl
- Requête (POST sur `http://localhost:8080/service/student-details`, `Content-Type: text/xml`) :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:st="http://www.exemple.org/student">
  <soapenv:Body>
    <st:StudentDetailsRequest>
      <st:name>Sajal</st:name>
    </st:StudentDetailsRequest>
  </soapenv:Body>
</soapenv:Envelope>
```
