#DESI WAY Smart Travel & Cultural Companion App IN
DESI WAY is a modern Android application built using Jetpack Compose that helps users explore travel destinations, Indian culture, food, adventure activities, safety features, and navigation tools in one unified platform.

This project is currently under active development and has reached a strong functional and architectural milestone, suitable for academic evaluation and further backend integration.

## Project Status (Current Progress)
Overall Progress: ~55-60% (Frontend + Navigation Complete)
- Core UI screens implemented
- Navigation architecture finalized
- Detail pages connected
- Centralized data handling via repository
- Reday for backend/API integration

## Tech Stack Used
- Language: Kotlin
- UI Framework: Jetpack Compose (Material 3)
- Architecture: MVVM-reday (Repository pattern in use)
- Navigation: Navigation Component (Compose)
- Image Loading: Coil
- Design Style:Gradient-based modern UI (Mustard Theme)

## App Features Implemented So Far

### 🏠 Home Screen
- Search Bar
- Top Visits Section
- Feature grid navigation
- Clickanle destination cards
- "View All" navigates to Travel Screen

### ✈️ Travel Module
- Categorized destinations:
  - Most Popular
  - Winter Picks
  - Summer Picks
  - Under Rated
- Clicking any place opens a shared Place Setail Screen
- Reusable card logic

### 🧭 Place Detail Screen (Centralized)
- Used by:
  - Home → Top Visits
  - Travel Screen
  - Favourite Screen
  - Dashboard → Recent Places
- Single source of truth using PlaceRepository

### ❤️ Favourite Screen
- Categorized favourites:
  - Destinations
  - Food
  - Adventure
- Destination cards navigate to Place Detail Screen
- Same navigation logic as parent screens

### 👤 Profile / Dashboard Screen
- Recent Places section
- Clickable cards → Plcae Detail Screen
- Activity overview (UI ready)

### 🍽 Food Module
- Categories:
  - Vegetarian
  - Non-Vegetarian
  - Fast Food
  - Drinks
- Food Detail Screen implemented
- Favourite toggle per item

### 🏞️ Adventure Module
- Categories:
  - Land Adventures
  - Water Adventures
  - Air Adventures
  - Snow Adventures
-Planned detail navigation (UI reday, backend pending)

### 🧕 Culture Module
- States & UTs grouped into:
  - North India
  - South India
  - West India
  - East India
  - Northeast India
  - Central India
- State Deatil Screen implemented
- Navigation working via NavGraph

### 🚨 Emergency Module
- SOS screen UI
- Prepared for:
  - Live location SMS
  - Haptic SOS trigger
 
### ⚠️ Scam Alert Module
- Scam price checker
- Currency converter (Currently just INR → USD, later all the connversions)
- UI complete (API pending)

### 🗺 Maps Module
- Custom maps UI
- Travel stats preview
- Ready for Google Maps SDK integration

## Architecture & Design Decisions

### Central Repository Pattern
''' 
PlaceRepository
      ↓
Home / Travel / favourite / Dashboard
      ↓
PlaceDetailScreen
'''
- Avoids data duplication
- Makes backend/API integration easier
- Ensures consistent UI & navigation

### Navigation Structure
- Single NavGraph.kt
- Feature routes + dynamic detail routes
- Clean deep-link friendly architecture

## Screenshots Section

# Home Screen

# Travel Screen

# Place Details Screen

# Food Screen

# Adventure Screen

# Culture Screen

# Emergency Screen

# Maps Screen

## Next Planned Development (Remaining 40-45%)
- Backend/API integration
- Google Maps SDK
- Real-time location sharing
- ML-based Scam Detection
- Authentication & user profiles
- Database (Room/Firebase)
- Push notifications
- Offline caching

## Academic Value
This project demonstrates:
- Modern Android UI development
- Clean navigation architecture
- Reusable component design
- Scalable project structure
- Industry-ready coding practices
