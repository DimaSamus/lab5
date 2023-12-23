package com.example.lab5;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/lab5/EmployeeViewModel;", "Landroidx/lifecycle/ViewModel;", "dao", "Lcom/example/lab5/EmployeeDao;", "(Lcom/example/lab5/EmployeeDao;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/lab5/EmployeeState;", "get_state", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "onEvent", "", "event", "Lcom/example/lab5/EmployeeEvent;", "app_debug"})
public final class EmployeeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.lab5.EmployeeDao dao = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.lab5.EmployeeState> _state = null;
    
    public EmployeeViewModel(@org.jetbrains.annotations.NotNull
    com.example.lab5.EmployeeDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<com.example.lab5.EmployeeState> get_state() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull
    com.example.lab5.EmployeeEvent event) {
    }
}