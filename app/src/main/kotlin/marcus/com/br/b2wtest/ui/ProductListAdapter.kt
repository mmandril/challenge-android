package marcus.com.br.b2wtest.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_best_seller_product.view.*
import marcus.com.br.b2wtest.R
import marcus.com.br.b2wtest.helper.toBRL
import marcus.com.br.b2wtest.model.data.ProductData

class ProductListAdapter : BaseRecyclerAdapter<ProductData>() {

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_best_seller_product,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return recyclerList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(recyclerList[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            productData: ProductData,
            listener: OnItemClickListener?
        ) = with(itemView) {
            itemBestProductContainer.setOnClickListener {
                listener?.onItemClick(this, adapterPosition)
            }

            Picasso.get()
                .load(productData.urlImage)
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.vector_img_not_found)
                .into(itemBestProductImage)

            itemBestProductName.text = productData.name
            itemBestProductFromPrice.text =
                resources.getString(R.string.product_from_price, productData.fromPrice.toBRL())
            itemBestProductToPrice.text =
                resources.getString(R.string.product_to_price, productData.toPrice.toBRL())

        }
    }
}