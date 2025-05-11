'use client'

import { useState } from 'react'
import { useRouter } from 'next/navigation'
import { createClient } from '@supabase/supabase-js'

const supabase = createClient(
    process.env.NEXT_PUBLIC_SUPABASE_URL!,
    process.env.NEXT_PUBLIC_SUPABASE_ANON_KEY!
)

export default function Cadastro() {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [nome, setNome] = useState('')
    const [erro, setErro] = useState('')
    const router = useRouter()

    const handleCadastro = async (e: React.FormEvent) => {
        e.preventDefault()
        setErro('')

        const { data: signupData, error: signupError } = await supabase.auth.signUp({
            email,
            password,
        })

        if (signupError) {
            setErro(signupError.message)
            return
        }

        const user = signupData.user
        if (user) {
            const { error: insertError } = await supabase.from('usuario').insert({
                id: user.id,
                nome: nome,
                administrador: false,
            })

            if (insertError) {
                setErro('Cadastro parcial feito, mas falha ao salvar dados adicionais.')
                return
            }

            router.push('/login') // ou para página principal
        }
    }

    return (
        <div>
            <h1>Cadastro</h1>
            <form onSubmit={handleCadastro}>
                <input
                    type="text"
                    placeholder="Nome"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
                    required
                />
                <br />
                <input
                    type="email"
                    placeholder="E-mail"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
                <br />
                <input
                    type="password"
                    placeholder="Senha"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />
                <br />
                <button type="submit">Cadastrar</button>
                {erro && <p style={{ color: 'red' }}>{erro}</p>}
            </form>
        </div>
    )
}
