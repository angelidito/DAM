// Generated by view binder compiler. Do not edit!
package com.sde.delgadosergio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sde.delgadosergio.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView cifTienda;

  @NonNull
  public final ImageView imgLogo;

  @NonNull
  public final TextView nombreTienda;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull TextView cifTienda,
      @NonNull ImageView imgLogo, @NonNull TextView nombreTienda) {
    this.rootView = rootView;
    this.cifTienda = cifTienda;
    this.imgLogo = imgLogo;
    this.nombreTienda = nombreTienda;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cifTienda;
      TextView cifTienda = ViewBindings.findChildViewById(rootView, id);
      if (cifTienda == null) {
        break missingId;
      }

      id = R.id.imgLogo;
      ImageView imgLogo = ViewBindings.findChildViewById(rootView, id);
      if (imgLogo == null) {
        break missingId;
      }

      id = R.id.nombreTienda;
      TextView nombreTienda = ViewBindings.findChildViewById(rootView, id);
      if (nombreTienda == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, cifTienda, imgLogo, nombreTienda);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
