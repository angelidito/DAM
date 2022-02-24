package com.sde.delgadosergio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0014\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/sde/delgadosergio/ProductoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sde/delgadosergio/ProductoAdapter$ViewHolder;", "productos", "", "Lcom/sde/delgadosergio/Producto;", "listener", "Lcom/sde/delgadosergio/EventosListenerProductos;", "(Ljava/util/List;Lcom/sde/delgadosergio/EventosListenerProductos;)V", "contexto", "Landroid/content/Context;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setProductos", "ViewHolder", "app_debug"})
public final class ProductoAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sde.delgadosergio.ProductoAdapter.ViewHolder> {
    private java.util.List<com.sde.delgadosergio.Producto> productos;
    private com.sde.delgadosergio.EventosListenerProductos listener;
    private android.content.Context contexto;
    
    public ProductoAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.sde.delgadosergio.Producto> productos, @org.jetbrains.annotations.NotNull()
    com.sde.delgadosergio.EventosListenerProductos listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.sde.delgadosergio.ProductoAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.sde.delgadosergio.ProductoAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void setProductos(@org.jetbrains.annotations.NotNull()
    java.util.List<com.sde.delgadosergio.Producto> productos) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/sde/delgadosergio/ProductoAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/sde/delgadosergio/ProductoAdapter;Landroid/view/View;)V", "binding", "Lcom/sde/delgadosergio/databinding/ItemProductoBinding;", "getBinding", "()Lcom/sde/delgadosergio/databinding/ItemProductoBinding;", "setListener", "", "productos", "Lcom/sde/delgadosergio/Producto;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.sde.delgadosergio.databinding.ItemProductoBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.sde.delgadosergio.databinding.ItemProductoBinding getBinding() {
            return null;
        }
        
        public final void setListener(@org.jetbrains.annotations.NotNull()
        com.sde.delgadosergio.Producto productos) {
        }
    }
}