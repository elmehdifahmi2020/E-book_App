package com.example.myapplication.addBook


import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.model.ModelBook
import java.util.Arrays

class AddBook : AppCompatActivity() {
    lateinit var pickImage: Button
    lateinit var selectedImage: ImageView
    lateinit var nameBook : EditText
    lateinit var writer : EditText
    lateinit var price : EditText
    lateinit var types_Book : Spinner
    lateinit var add_Book : Button
    lateinit var adapter : ArrayAdapter<String>
    var resourceId: Int = 0

    companion object {
        const val CAMERA_PERMISSION_REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)
        pickImage = findViewById(R.id.update_img)
        selectedImage = findViewById(R.id.book_img)
        nameBook = findViewById(R.id.book_name)
        writer = findViewById(R.id.book_author)
        price = findViewById(R.id.book_price)
        types_Book = findViewById(R.id.sp_type)
        add_Book = findViewById(R.id.add)
        fillSpinner(types_Book)
        pickImage.setOnClickListener {
            if (checkPermission()) {
                openImagePicker()
            } else {
                // Permission is not granted, request it
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_REQUEST_CODE
                )
            }
        }
        resourceId= (selectedImage.drawable as BitmapDrawable).bitmap.let { bitmap ->
            val imageName = resources.getResourceName(selectedImage.id)
            resources.getIdentifier(imageName, "drawable", packageName)
        }
        add_Book.setOnClickListener {
            if (checkedAllFields()){
                addBook(it)
            }



        }

    }
    private fun checkPermission():Boolean{
        return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

    private fun openImagePicker() {
        val pickImg = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        changeImage.launch(pickImg)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, open image picker
                openImagePicker()
            } else {
                // Permission denied, show a message or handle accordingly
                Toast.makeText(this,"Camera permission denied,please allow permission to take picture .",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    private val changeImage = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            val data = it.data
            val imgUri = data?.data
            selectedImage.setImageURI(imgUri)
        }
    }
    private fun checkedAllFields():Boolean{
        if (nameBook.length() == 0){
            nameBook.setError("This field is required")
            return false
        }
        if (writer.length() == 0){
            writer.setError("This field is required")
        }
        if (price.length() == 0){
            price.setError("This field is required")
        }
        return true
    }
    fun fillSpinner(spinner: Spinner){

        adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item, listOf("ReadBook","AudioBook"))
        spinner.adapter = adapter
    }

    fun addBook(it : View?){
        val title = nameBook.text.toString()
        val book = ModelBook("title",R.drawable.palestine)
        var bundle = Bundle()
        var intent = Intent(this@AddBook, MainActivity::class.java)
        bundle.putString("title",title)
        bundle.putString("Writer",writer.text.toString())
        bundle.putString("price",price.text.toString())
        bundle.putString("type",types_Book.selectedItem.toString())
        intent.putExtras(bundle)
        startActivity(intent)
    }


}
