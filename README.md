# Digital Access Order Processing System

An enterprise-grade backend system for managing digital access requests, designed to simulate real-world approval workflows commonly found in large organizations.

The system allows users to request access to internal services (e.g., GitHub, Jira, Confluence), persists requests reliably, and processes approvals asynchronously using Temporal workflows.

---

## 🧩 Problem Statement

In large organizations, access to internal systems is not granted instantly.  
Requests must be:
- Validated
- Approved asynchronously
- Auditable and reliable across failures

Traditional synchronous APIs are not well-suited for such long-running, stateful workflows.

---

## 🚀 Solution Overview

This project implements a **Digital Access Order Processing System** that:

- Accepts access requests via REST APIs
- Persists access orders using a relational database
- Orchestrates long-running approval workflows using **Temporal**
- Separates workflow orchestration from business logic
- Is built using **Bazel** for strict dependency management

---

## 🏗 Architecture
Client
|
| REST API
v
Spring Boot Controller
|
v
Service Layer
|        
|         –> Temporal Workflow
|                 |
|                 –> Validation Activity
|                 –> Approval Activity
|
v
JPA Persistence (H2 / RDBMS)

---

## 🔧 Tech Stack

- **Backend**: Java 17, Spring Boot
- **Build System**: Bazel
- **Workflow Orchestration**: Temporal
- **Persistence**: Spring Data JPA, H2
- **API Style**: REST
- **Local Runtime**: Temporal Dev Server (CLI)

---

## 📌 Key Design Decisions

- **Service-layer orchestration**: Workflows are started only after successful persistence
- **Immutable domain model**: Prevents invalid state transitions
- **Asynchronous processing**: API remains responsive while workflows run independently
- **Explicit dependency management**: Bazel enforces clean module boundaries

---

## ▶ Running Locally

### Start Temporal Dev Server
```bash
temporal server start-dev