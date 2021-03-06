package marcus.com.br.b2wtest.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import marcus.com.br.b2wtest.ui.categoryproduct.CategoryProductViewModel
import marcus.com.br.b2wtest.ui.main.home.HomeViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CategoryProductViewModel::class)
    abstract fun bindCategoryProductViewModel(viewModel: CategoryProductViewModel): ViewModel
}