package com.examen.martinezangel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/examen/martinezangel/CategoriasActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/ammd/martinezangel/EventosListener;", "()V", "adaptador", "Lcom/ammd/martinezangel/CategoriasAdapter;", "binding", "Lcom/examen/martinezangel/databinding/ActivityCategoriasBinding;", "database", "Lcom/examen/martinezangel/EmpresaDAO;", "gridLayout", "Landroidx/recyclerview/widget/GridLayoutManager;", "configurarRecycler", "", "onClickListenerCall", "code", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "getAllCategoriasAsyncTask", "app_debug"})
public final class CategoriasActivity extends androidx.appcompat.app.AppCompatActivity implements com.ammd.martinezangel.EventosListener {
    private com.examen.martinezangel.databinding.ActivityCategoriasBinding binding;
    private com.examen.martinezangel.EmpresaDAO database;
    private com.ammd.martinezangel.CategoriasAdapter adaptador;
    private androidx.recyclerview.widget.GridLayoutManager gridLayout;
    
    public CategoriasActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void configurarRecycler() {
    }
    
    @java.lang.Override()
    public void onClickListenerCall(int code) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0005J+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\b\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/examen/martinezangel/CategoriasActivity$getAllCategoriasAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "Lcom/examen/martinezangel/Categoria;", "(Lcom/examen/martinezangel/CategoriasActivity;)V", "doInBackground", "p0", "", "([Ljava/lang/Void;)Ljava/util/List;", "onPostExecute", "", "result", "app_debug"})
    final class getAllCategoriasAsyncTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.examen.martinezangel.Categoria>> {
        
        public getAllCategoriasAsyncTask() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected java.util.List<com.examen.martinezangel.Categoria> doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.Void... p0) {
            return null;
        }
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.Nullable()
        java.util.List<com.examen.martinezangel.Categoria> result) {
        }
    }
}