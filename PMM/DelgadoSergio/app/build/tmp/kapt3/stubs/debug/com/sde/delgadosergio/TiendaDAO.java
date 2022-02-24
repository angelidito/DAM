package com.sde.delgadosergio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/sde/delgadosergio/TiendaDAO;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBD", "Landroid/database/sqlite/SQLiteDatabase;", "addProductoFavoritos", "", "codUsuario", "", "codProducto", "consultaCategorias", "", "Lcom/sde/delgadosergio/Categoria;", "consultaLogin", "usuario", "pass", "consultaProductosCategoria", "Lcom/sde/delgadosergio/Producto;", "codCategoria", "", "eliminarProductoLista", "productoEstaEnFavoritos", "", "Companion", "app_debug"})
public final class TiendaDAO {
    private final android.database.sqlite.SQLiteDatabase mBD = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.sde.delgadosergio.TiendaDAO.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "DelgadoSergio";
    public static final int DATABASE_VERSION = 1;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLA_CATEGORIAS = "categorias";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLA_PRODUCTOS = "productos";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLA_USUARIOS = "usuarios";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLA_LISTA_DESEOS = "listaDeseos";
    
    public TiendaDAO(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String consultaLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario, @org.jetbrains.annotations.NotNull()
    java.lang.String pass) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.sde.delgadosergio.Categoria> consultaCategorias() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.sde.delgadosergio.Producto> consultaProductosCategoria(int codCategoria) {
        return null;
    }
    
    public final boolean productoEstaEnFavoritos(@org.jetbrains.annotations.NotNull()
    java.lang.String codUsuario, @org.jetbrains.annotations.NotNull()
    java.lang.String codProducto) {
        return false;
    }
    
    public final void addProductoFavoritos(@org.jetbrains.annotations.NotNull()
    java.lang.String codUsuario, @org.jetbrains.annotations.NotNull()
    java.lang.String codProducto) {
    }
    
    public final void eliminarProductoLista(@org.jetbrains.annotations.NotNull()
    java.lang.String codUsuario, @org.jetbrains.annotations.NotNull()
    java.lang.String codProducto) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/sde/delgadosergio/TiendaDAO$Companion;", "", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "TABLA_CATEGORIAS", "TABLA_LISTA_DESEOS", "TABLA_PRODUCTOS", "TABLA_USUARIOS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}