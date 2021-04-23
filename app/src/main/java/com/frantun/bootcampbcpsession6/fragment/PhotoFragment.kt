package com.frantun.bootcampbcpsession6.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.frantun.bootcampbcpsession6.databinding.FragmentPhotoBinding

class PhotoFragment : Fragment() {

    private lateinit var binding: FragmentPhotoBinding

    private var photo: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = arguments
        args?.let {
            photo = args.getInt(TAG_PHOTO)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUI()
    }

    private fun setUI() {
        photo?.let {
            binding.photoImageView.setImageDrawable(ContextCompat.getDrawable(requireContext(), it))
        }
    }

    companion object {
        private const val TAG_PHOTO = "TAG_PHOTO"

        fun newInstance(photo: Int): PhotoFragment {
            val args = Bundle()
            args.putInt(TAG_PHOTO, photo)
            val fragment = PhotoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}