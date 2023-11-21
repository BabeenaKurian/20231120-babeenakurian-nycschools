import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SchoolDetails
import com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.MainActivity
import com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.school.SchoolListViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainActivityTest {


    @Mock
    lateinit var viewModel: SchoolListViewModel

    @Mock
    lateinit var pagedList: PagedList<SchoolDetails?>

    private lateinit var mainActivity: MainActivity

    @Before
    fun setup() {
        mainActivity = MainActivity()
        mainActivity.mViewModel = viewModel
    }

    @Test
    fun testRecyclerViewSetup() {
        val fakeList = MutableLiveData<PagedList<SchoolDetails?>>()
        `when`(viewModel.schoolDetailsList).thenReturn(fakeList)

        // Call onCreate to initialize the RecyclerView
        mainActivity.onCreate(null)

        // Check if RecyclerView and ViewModel are properly initialized
        assert(mainActivity.recyclerView != null)
        assert(mainActivity.mViewModel != null)
    }

    @Test
    fun testDataFromServer() {
        val fakeList = MutableLiveData<PagedList<SchoolDetails?>>()
        fakeList.value = pagedList

        `when`(viewModel.schoolDetailsList).thenReturn(fakeList)

        // Call dataFromServer method to observe changes from ViewModel
        mainActivity.dataFromServer

        // Verify that the adapter is updated with the observed list from ViewModel
        // (You might need to implement an assert here depending on your specific adapter logic)
    }
}