package com.sde.delgadosergio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/sde/delgadosergio/ConsultaCategoriasActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/sde/delgadosergio/EventosListener;", "()V", "adaptador", "Lcom/sde/delgadosergio/CategoriaAdapter;", "bd", "Lcom/sde/delgadosergio/TiendaDAO;", "binding", "Lcom/sde/delgadosergio/databinding/ActivityConsultaCategoriasBinding;", "codUsuario", "", "gridLayout", "Landroidx/recyclerview/widget/GridLayoutManager;", "configurarRecyclerCategorias", "", "consultaCategorias", "onClickListener", "categoria", "Lcom/sde/delgadosergio/Categoria;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class ConsultaCategoriasActivity extends androidx.appcompat.app.AppCompatActivity implements com.sde.delgadosergio.EventosListener {
    private com.sde.delgadosergio.databinding.ActivityConsultaCategoriasBinding binding;
    private com.sde.delgadosergio.CategoriaAdapter adaptador;
    private androidx.recyclerview.widget.GridLayoutManager gridLayout;
    private com.sde.delgadosergio.TiendaDAO bd;
    private java.lang.String codUsuario;
    @org.jetbrains.annotations.NotNull()
    public static final com.sde.delgadosergio.ConsultaCategoriasActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COD_USUARIO = "codUsuario";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COD_CATEGORIA = "codCategoria";
    
    public ConsultaCategoriasActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void configurarRecyclerCategorias() {
    }
    
    private final void consultaCategorias() {
    }
    
    @java.lang.Override()
    public void onClickListener(@org.jetbrains.annotations.NotNull()
    com.sde.delgadosergio.Categoria categoria) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/sde/delgadosergio/ConsultaCategoriasActivity$Companion;", "", "()V", "COD_CATEGORIA", "", "COD_USUARIO", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}