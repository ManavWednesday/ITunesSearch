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
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ItunesViewModelTest {

    @FlowPreview
    @Mock
    private lateinit var viewModel: ItunesViewModel

    @Mock
    private val fakeRepo: FakeRepo = FakeRepo()

    private lateinit var testCoroutineDispatcher:TestCoroutineDispatcher

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @ObsoleteCoroutinesApi
    @FlowPreview
    @Before
    fun onSetup(){
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
        Mockito.`when`(fakeRepo.search("Thunder")).thenReturn(arrayListOf(RemoteDataModel()))
        viewModel.search("Thunder")
        viewModel.searchSongsList.observeForever {
            assertEquals(viewModel.searchSongsList.value, arrayListOf(RemoteDataModel()))
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