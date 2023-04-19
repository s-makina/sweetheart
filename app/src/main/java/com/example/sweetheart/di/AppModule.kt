package com.example.sweetheart.di

import com.example.sweetheart.data.entity.Customer
import com.example.sweetheart.data.entity.OrderEntity
import com.example.sweetheart.data.entity.SaleEntity
import com.example.sweetheart.data.entity.SupplerEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRealmDb(): Realm {
        val config = RealmConfiguration.Builder(
            setOf(
                Customer::class,
                OrderEntity::class,
                SupplerEntity::class,
                SaleEntity::class,
            )
        ).build()
        return Realm.open(config)
    }
}