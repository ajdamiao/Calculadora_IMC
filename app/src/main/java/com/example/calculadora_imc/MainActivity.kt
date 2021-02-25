package com.example.calculadora_imc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadora_imc.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        var btnCalcular = binding.btnCalcular;
        val mensagem = binding.mensagem;

        btnCalcular.setOnClickListener()
        {
            var editPeso = binding.editPeso.text.toString();
            var editAltura = binding.editAltura.text.toString();

            if(editPeso.isEmpty())
            {
                mensagem.setText("Peso não foi inserido");
            }
            else if(editAltura.isEmpty())
            {
                mensagem.setText("Altura nao foi inserida");
            }
            else
            {
                calculoIMC(editPeso,editAltura);
            }

        }
    }

    private fun calculoIMC(pesoID:String, alturaID:String)
    {
        var peso = Integer.parseInt(pesoID);
        var altura = java.lang.Float.parseFloat(alturaID);
        var mensagem = binding.mensagem;
        var imc = peso/(altura * altura);

        if(imc<18.5)
        {
            mensagem.setText("IMC = $imc (Peso Baixo)");
        }
        else if(imc<=24.9 && imc>18.5)
        {
            mensagem.setText("IMC = $imc (Peso Normal)");
        }
        else if(imc<=29.9 && imc>25.0)
        {
            mensagem.setText("IMC = $imc (Sobrepeso)");
        }
        else if(imc<=34.9 && imc>30.0)
        {
            mensagem.setText("IMC = $imc (Obesidade)");
        }
    }
}