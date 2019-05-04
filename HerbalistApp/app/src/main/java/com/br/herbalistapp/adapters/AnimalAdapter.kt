package com.br.herbalistapp.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.br.herbalistapp.R
import com.br.herbalistapp.domain.Animal
import com.squareup.picasso.Picasso

class AnimalAdapter (
    val animals: List<Animal>,

    val onClick: (Animal) -> Unit): RecyclerView.Adapter<AnimalAdapter.DisciplinasViewHolder>() {
    // ViewHolder com os elementos da tela
    class DisciplinasViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg : ImageView
        var cardProgress: ProgressBar
        var cardView: CardView
        init {
            cardNome = view.findViewById<TextView>(R.id.cardNome)
            cardImg = view.findViewById<ImageView>(R.id.cardImg)
            cardProgress = view.findViewById<ProgressBar>(R.id.cardProgress)
            cardView = view.findViewById<CardView>(R.id.card_animals)
        }
    }

    // Quantidade de animals na lista
    override fun getItemCount() = this.animals.size

    // inflar layout do adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisciplinasViewHolder {
// infla view no adapter
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_animal, parent, false)
// retornar ViewHolder
        val holder = DisciplinasViewHolder(view)
        return holder
    }

    // bind para atualizar Views com os dados
    override fun onBindViewHolder(holder: DisciplinasViewHolder, position: Int) {
        val context = holder.itemView.context
// recuperar objeto disciplina
        val animal = animals[position]
// atualizar dados de disciplina
        holder.cardNome.text = animal.name
        holder.cardProgress.visibility = View.VISIBLE
// download da imagem
        Picasso.with(context).load(animal.pictureUrl).fit().into(holder.cardImg,

            object: com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }
                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })

// adiciona evento de clique
        holder.itemView.setOnClickListener {onClick(animal)}
    }
}