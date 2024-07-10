package com.example.learningretrofit.data

import coil.network.HttpException
import com.example.learningretrofit.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttp
import okio.IOException

class ProductsRepositoryImplementation (
    private val api: Api
) : ProductsRepository {
    override suspend fun getProductsList(): Flow<Result<List<Product>>> {
        return flow {
            val productsFromAPI = try {
                api.getProductsList()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading the products"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading the products"))
                return@flow
            }

            emit(Result.Success(data = productsFromAPI.products))
        }
    }
}