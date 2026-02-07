# Enigma 🤖

An intelligent Telegram bot for group and channel moderation that detects spam, analyzes toxicity, enforces community guidelines, and provides intelligent chat summarization.

## 🎯 Project Overview

Enigma is a sophisticated Telegram bot built with Spring Boot that serves as an automated moderator and community assistant. It leverages AI-powered analysis (powered by my own custom CoreAI module) to maintain healthy group/channel environments by detecting harmful content, warning violators, and helping users stay informed through intelligent message summarization.

### Core Responsibilities
- **Spam Detection**: Identify and flag repetitive or unsolicited messages
- **Toxicity Analysis**: Analyze message content for harmful, offensive, or inappropriate language
- **User Warnings**: Issue warnings to users who violate community guidelines
- **Moderation Actions**: Automatically mute or ban users based on violation severity and frequency
- **Chat Summarization**: Generate concise summaries of ongoing conversations for users who need context

## 🛠 Tech Stack

- **Framework**: Spring Boot 4.0.2
- **Language**: Java 17
- **Build Tool**: Maven
- **AI Engine**: Custom CoreAI module (v0.0.1-SNAPSHOT)
- **Messaging Platform**: Telegram Bot API (v6.0.1)
- **Database**: MySQL with Spring Data JPA
- **Networking**: Project Reactor & Netty for async operations
- **Utilities**: Lombok for cleaner code, SLF4J for logging

## ✨ Features

### Core Moderation Features
- 🛡️ **Real-time Spam Detection** - Identifies repetitive messages and pattern-based spam
- 📢 **Toxicity Analysis** - Analyzes message sentiment and flags offensive content
- ⚠️ **Smart Warnings** - Graduated warning system before taking action
- 🚫 **Automatic Moderation** - Temporary or permanent user restrictions based on violations
- 📊 **User Violation Tracking** - Maintains history of violations per user

### Intelligent Assistance
- 📝 **Chat Summarization** - Generate summaries of group discussions on demand
- 🔍 **Context Awareness** - Understand conversation flow and context
- 💬 **Natural Interaction** - Friendly, conversational bot responses

### Admin Features
- ⚙️ **Configurable Thresholds** - Customize spam and toxicity detection sensitivity
- 🎛️ **Custom Rules** - Define group-specific moderation rules
- 📈 **Analytics & Reporting** - View moderation statistics and user reports
- 🔐 **Role-based Control** - Admin-only commands and configurations


## 📝 Database Schema Overview

The bot maintains several key tables:

- **users** - Telegram user information
- **violations** - User violation records (spam, toxicity incidents)
- **warnings** - Warning history per user
- **group_settings** - Per-group moderation configurations
- **message_cache** - Recent messages for summarization context
- **moderation_actions** - History of mutes and bans



## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Make your changes with clear commit messages
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request with description of changes



## 👤 Author

**AslamIktelat**
- GitHub: [@AslamIktelat](https://github.com/AslamIktelat)

## 📞 Support & Feedback

For issues, feature requests, or suggestions:
- Open an issue on [GitHub Issues](https://github.com/AslamIktelat/enigma/issues)
- Include relevant logs and configuration details
- Describe the expected vs. actual behavior


---

> **Note**: This is an active development project. Features and APIs may change. Please report bugs and suggest improvements!