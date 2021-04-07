package com.example.imageapp.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imageapp.Network.RetrofitRepository;
import com.example.imageapp.models.ResponseModel;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainActivityViewModel extends ViewModel {

    CompositeDisposable disposable = new CompositeDisposable();

    public MutableLiveData<ResponseModel> liveData = new MutableLiveData<>();

    private RetrofitRepository repository;

    public MainActivityViewModel() {
    }

    public void init() {
        repository = RetrofitRepository.getInstance();
    }

    public void getPosts() {
        repository.getPosts()
                .doOnSubscribe(d -> disposable.add(d))
                .subscribe(posts -> liveData.postValue(posts), throwable -> {
                });
    }

    public MutableLiveData<ResponseModel> getArticles() {
        return liveData;
    }

    @Override
    protected void onCleared() {
        if (!disposable.isDisposed()) disposable.dispose();
        super.onCleared();
    }
}
