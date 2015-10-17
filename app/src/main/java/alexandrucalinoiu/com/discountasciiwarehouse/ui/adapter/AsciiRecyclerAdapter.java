package alexandrucalinoiu.com.discountasciiwarehouse.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import alexandrucalinoiu.com.discountasciiwarehouse.R;
import alexandrucalinoiu.com.discountasciiwarehouse.databinding.AsciiLayoutBinding;
import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.Ascii;
import alexandrucalinoiu.com.discountasciiwarehouse.ui.viewmodel.AsciiViewModel;

public class AsciiRecyclerAdapter extends RecyclerView.Adapter<AsciiRecyclerAdapter.AsciiViewHolder> {
  private List<Ascii> asciis;

  public AsciiRecyclerAdapter(List<Ascii> asciis) {
    this.asciis = asciis;
  }

  @Override
  public AsciiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.
        from(parent.getContext()).
        inflate(R.layout.ascii_layout, parent, false);
    return new AsciiViewHolder(itemView);

  }

  @Override
  public void onBindViewHolder(AsciiViewHolder holder, int position) {
    final Ascii ascii = asciis.get(position);
    holder.bind(ascii);
  }

  @Override
  public int getItemCount() {
    return asciis.size();
  }

  final static class AsciiViewHolder extends RecyclerView.ViewHolder {


    private final AsciiLayoutBinding asciiLayoutBinding;

    public AsciiViewHolder(View itemView) {
      super(itemView);
      asciiLayoutBinding = DataBindingUtil.bind(itemView);
    }

    public void bind(Ascii ascii) {
      asciiLayoutBinding.setViewModel(new AsciiViewModel(ascii));
    }
  }
}
