package com.example.itunesapp.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.itunesapp.model.RemoteDataModel
import com.example.itunesapp.repository.FakeRepo
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ItunesViewModelTest {

    @FlowPreview
    private lateinit var viewModel: ItunesViewModel


    private lateinit var  fakeRepo: FakeRepo

    private lateinit var testCoroutineDispatcher:TestCoroutineDispatcher

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @ObsoleteCoroutinesApi
    @FlowPreview
    @Before
    fun onSetup(){
        fakeRepo = mock()
        testCoroutineDispatcher = TestCoroutineDispatcher()
        Dispatchers.setMain(mainThreadSurrogate)
        viewModel = ItunesViewModel(fakeRepo)
    }

    @ObsoleteCoroutinesApi
    @After
    fun cleanUp(){
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

//    @get:Rule
//    val coroutinesDispatcherRule = CoroutineDispatcherRule()

    @FlowPreview
    @Test
    fun `when empty value is passed list should be empty`() = testCoroutineDispatcher.runBlockingTest {
            viewModel.search("")
            assertEquals(null,viewModel.searchSongsList.value)
    }

    @FlowPreview
    @Test
    fun `when name is passed the list should contain values`() = testCoroutineDispatcher.runBlockingTest{
        //whenever(fakeRepo.search("Thunder")).thenReturn(arrayListOf(RemoteDataModel()))
        //Mockito.`when`(fakeRepo.search("Thunder")).thenReturn(arrayListOf(RemoteDataModel()))
        viewModel.search("Thunder")

        viewModel.searchSongsList.observeForever {
            assertEquals(viewModel.searchSongsList.value, arrayListOf(RemoteDataModel()))
            runBlockingTest {
                Mockito.verify(fakeRepo, times(1)).search("Thunder")
            }
        }
    }

//    @Test
//    fun `if the song description is there in database then values should be fetched from there`(){
//
//    }

//    @Test
//    fun `if not in DB then call api`(){
//
//    }

}