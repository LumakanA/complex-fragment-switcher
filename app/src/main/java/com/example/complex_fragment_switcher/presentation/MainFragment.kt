package com.example.complex_fragment_switcher.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.example.complex_fragment_switcher.R
import com.example.complex_fragment_switcher.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var currentLetterFragment: Fragment? = null
    private var currentNumberFragment: Fragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        val aFragment = AFragment()
        val bFragment = BFragment()
        val cFragment = CFragment()

        val oneFragment = OneFragment()
        val twoFragment = TwoFragment()
        val threeFragment = ThreeFragment()

        binding.buttonA.setOnClickListener {
            if (currentLetterFragment !is AFragment) {
                currentLetterFragment = aFragment
                replaceLetterFragment(aFragment)
            }
        }

        binding.buttonB.setOnClickListener {
            if (currentLetterFragment !is BFragment) {
                currentLetterFragment = bFragment
                replaceLetterFragment(bFragment)
            }
        }

        binding.buttonC.setOnClickListener {
            if (currentLetterFragment !is CFragment) {
                currentLetterFragment = cFragment
                replaceLetterFragment(cFragment)
            }
        }

        binding.buttonOne.setOnClickListener {
            if (currentNumberFragment !is OneFragment) {
                currentNumberFragment = oneFragment
                replaceNumberFragment(oneFragment)
            }
        }

        binding.buttonTwo.setOnClickListener {
            if (currentNumberFragment !is TwoFragment) {
                currentNumberFragment = twoFragment
                replaceNumberFragment(twoFragment)
            }
        }

        binding.buttonThree.setOnClickListener {
            if (currentNumberFragment !is ThreeFragment) {
                currentNumberFragment = threeFragment
                replaceNumberFragment(threeFragment)
            }
        }

        return binding.root
    }

    private fun replaceLetterFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerLetters, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun replaceNumberFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerNumbers, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            val defaultLetterFragment = AFragment()
            val defaultNumberFragment = OneFragment()
            replaceLetterFragment(defaultLetterFragment)
            replaceNumberFragment(defaultNumberFragment)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            val defaultLetterFragment = AFragment()
            val defaultNumberFragment = OneFragment()

            if (currentLetterFragment == defaultLetterFragment && currentNumberFragment == defaultNumberFragment) {
                requireActivity().finish()
            } else {
                val backStackCount = parentFragmentManager.backStackEntryCount
                if (backStackCount <= 2) {
                    requireActivity().finish()
                } else {
                    if (!parentFragmentManager.popBackStackImmediate()) {
                        requireActivity().finish()
                    }
                }
            }
        }
    }
}
