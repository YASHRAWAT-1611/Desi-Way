package com.yashrawwt.desiway.ui.theme.data

import androidx.compose.runtime.mutableStateListOf
import com.yashrawwt.desiway.ui.theme.models.FavoriteType

/**
 * Central Favourite Manager
 * Single source of truth for all liked items
 */
object FavoriteRepository {

    data class FavoriteItem(
        val id: String,
        val type: FavoriteType
    )

    /** Compose-aware state list */
    private val _favorites = mutableStateListOf<FavoriteItem>()
    val favorites: List<FavoriteItem> get() = _favorites

    /* ---------------- CHECK ---------------- */

    fun isFavorite(id: String, type: FavoriteType): Boolean {
        return _favorites.any { it.id == id && it.type == type }
    }

    /* ---------------- TOGGLE ---------------- */

    fun toggleFavorite(id: String, type: FavoriteType) {
        val existingIndex = _favorites.indexOfFirst {
            it.id == id && it.type == type
        }

        if (existingIndex >= 0) {
            _favorites.removeAt(existingIndex)
        } else {
            _favorites.add(FavoriteItem(id, type))
        }
    }

    /* ---------------- FILTER ---------------- */

    fun getFavoritesByType(type: FavoriteType): List<String> {
        return _favorites
            .filter { it.type == type }
            .map { it.id }
    }

    /* ---------------- CLEAR (Optional) ---------------- */

    fun clearAll() {
        _favorites.clear()
    }
}
