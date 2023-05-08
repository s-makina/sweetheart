package com.example.sweetheart.di

import com.example.sweetheart.data.repo.MainRepo
import com.example.sweetheart.data.repo.OrdersRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {
    @Provides
    fun provideMainRepo(db: Realm) = MainRepo(db)
    @Provides
    fun provideOrdersRepo(db: Realm) = OrdersRepo(db)
}