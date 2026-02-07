# Enigma AI 🤖
### *Autonomous Governance & Intelligence Engine*

**Enigma** is a high-performance orchestration service built on **Spring AI** and **Java 21**. It is designed to manage community health through autonomous moderation and real-time tracking of user reputation.

## 🚀 Phase 1: Core Agentic Engine (Current)
- **Agentic Moderation**: Leverages **Spring AI Function Calling** to allow the LLM to autonomously trigger administrative actions (mute, ban, warn) via the Telegram API.
- **Toxicity Scoring**: Implements a nuanced $0-100$ scoring system to categorize and respond to violations based on severity.
- **Reputation (Karma) System**: A persistence-backed engine that tracks user behavior and applies rewards or penalties based on AI-derived sentiment.
- **Reactive Architecture**: Built with an asynchronous processing pipeline to handle high-traffic group environments without latency.

## 🛠 Tech Stack
* **Runtime**: Java 21 (utilizing Virtual Threads for I/O efficiency)
* **Framework**: Spring Boot 3.4+
* **AI Orchestration**: **Spring AI** (OpenAI integration)
* **Persistence**: PostgreSQL (RAG-ready schema)
* **Messaging**: Telegram Bot SDK

## 🗺 Roadmap (Future Phases)
- [ ] **Phase 2: Hybrid Memory (RAG)**: Integration of **PGVector** to enable semantic search and Q&A over historical chat data.
- [ ] **Phase 3: Conversational Synthesis**: Automatic generation of "While you were away" summaries using retrieved vector context.
- [ ] **Phase 4: Multi-Modal Support**: Voice-to-task conversion and image-based spam detection.

## 🏗 System Design
The system is designed with a **Modular AI Gateway**. Incoming messages are processed by a moderation agent, which decides whether to invoke local tools (SQL updates) or external tools (Telegram API).
