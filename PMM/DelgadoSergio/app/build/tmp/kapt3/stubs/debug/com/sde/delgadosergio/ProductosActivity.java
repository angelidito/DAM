package com.sde.delgadosergio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/sde/delgadosergio/ProductosActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/sde/delgadosergio/EventosListenerProductos;", "()V", "adaptador", "Lcom/sde/delgadosergio/ProductoAdapter;", "bd", "Lcom/sde/delgadosergio/TiendaDAO;", "binding", "Lcom/sde/delgadosergio/databinding/ActivityProductosBinding;", "codCategoria", "", "codUsuario", "", "gridLayout", "Landroidx/recyclerview/widget/GridLayoutManager;", "configurarRecyclerProductosCategoria", "", "consultaCategorias", "onClickListener", "producto", "Lcom/sde/delgadosergio/Producto;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class ProductosActivity extends androidx.appcompat.app.AppCompatActivity implements com.sde.delgadosergio.EventosListenerProductos {
    private com.sde.delgadosergio.databinding.ActivityProductosBinding binding;
    private com.sde.delgadosergio.ProductoAdapter adaptador;
    private androidx.recyclerview.widget.GridLayoutManager gridLayout;
    private com.sde.delgadosergio.TiendaDAO bd;
    private int codCategoria = 0;
    private java.lang.String codUsuario;
    @org.jetbrains.annotations.NotNull()
    public static final com.sde.delgadosergio.ProductosActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COD_USUARIO = "usuario";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PRODUCTO = "producto";
    
    public ProductosActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void configurarRecyclerProductosCategoria() {
    }
    
    private final void consultaCategorias() {
    }
    
    @java.lang.Override()
    public void onClickListener(@org.jetbrains.annotations.NotNull()
    com.sde.delgadosergio.Producto producto) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/sde/delgadosergio/ProductosActivity$Companion;", "", "()V", "COD_USUARIO", "", "PRODUCTO", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}