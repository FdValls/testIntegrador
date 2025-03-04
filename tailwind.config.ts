import { heroui } from "@heroui/react";
import type { Config } from "tailwindcss" with { "resolution-mode": "import" };
import { addDynamicIconSelectors } from "@iconify/tailwind";


export default {
    content: [
        "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
        "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
        "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
        "./node_modules/@heroui/theme/dist/**/*.{js,ts,jsx,tsx}",
    ],
    darkMode: "class",
    plugins: [heroui(), addDynamicIconSelectors()],
} satisfies Config;
