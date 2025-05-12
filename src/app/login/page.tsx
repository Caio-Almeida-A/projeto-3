"use client"

import { useState } from "react"
import Link from "next/link"
import { Button } from "@/components/ui/button"
import { Checkbox } from "@/components/ui/checkbox"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"

export default function LoginPage() {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [rememberMe, setRememberMe] = useState(false)

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault()
        console.log({ email, password, rememberMe })
    }

    return (
        <div className="flex min-h-screen items-center justify-center bg-gray-50">
            <div className="w-full max-w-md">
                <div className="rounded-md bg-white p-8 shadow-sm">
                    <h1 className="mb-4 text-center text-3xl font-semibold text-teal-600">Login</h1>
                    <div className="mb-6 border-b border-gray-200"></div>

                    <form onSubmit={handleSubmit}>
                        <div className="mb-4">
                            <Label htmlFor="email" className="mb-1 block text-sm font-medium text-gray-700">
                                Seu e-mail
                            </Label>
                            <Input
                                id="email"
                                type="email"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                placeholder="contato@exemplo.com"
                                className="w-full rounded-md border border-gray-300"
                                required
                            />
                        </div>

                        <div className="mb-4">
                            <Label htmlFor="password" className="mb-1 block text-sm font-medium text-gray-700">
                                Sua senha
                            </Label>
                            <Input
                                id="password"
                                type="password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                placeholder="1234"
                                className="w-full rounded-md border border-gray-300"
                                required
                            />
                        </div>

                        <div className="mb-6 flex items-center">
                            <Checkbox
                                id="remember"
                                checked={rememberMe}
                                onCheckedChange={(checked) => setRememberMe(checked as boolean)}
                                className="h-4 w-4 rounded border-gray-300 text-teal-600"
                            />
                            <Label htmlFor="remember" className="ml-2 text-sm text-gray-700">
                                Manter-me logado
                            </Label>
                        </div>

                        <Button type="submit" className="w-full rounded-md bg-teal-500 py-2 text-white hover:bg-teal-600">
                            Logar
                        </Button>
                    </form>
                </div>

                <div className="mt-2 rounded-md bg-gray-100/80 p-4 text-center text-sm">
                    <span className="text-gray-600">Ainda não tem conta?</span>{" "}
                    <Link href="/cadastro" className="text-teal-500 hover:underline">
                        Cadastre-se
                    </Link>
                </div>
            </div>
        </div>
    )
}
