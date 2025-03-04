"use client"

import { Card, CardHeader, CardBody, Image } from "@heroui/react";
import { useEffect, useState } from "react";
import imagesSWAPI from "./utils/images";
import { Icon } from "@iconify/react";

interface Character {
    name: string;
    birth_year: string;
    gender: string;
    data: unknown;
    imgUrl?: string
}
export default function CardSWAPI() {
    const [data, setData] = useState<Character[]>([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(
                    `http://localhost:8080/swapi/peopleFromDB`,
                    {
                        method: "GET",
                        headers: {
                            "Content-Type": "application/json",
                        },
                    },
                );
                const result = await response.json();
                setData(result.data as Character[]);


            } catch (error) {
                console.log("ok: " + error);
            }
        };

        fetchData();
    }, []);

    // console.log(data);

    return (
        <>
            <div className="grid grid-cols-1 justify-items-center my-12">
                <div className="flex flex-row items-center gap-4 ">
                    <h1>
                        <p className="text-4xl text-amber-300">SWAPI</p>
                    </h1>
                    <div className="bg-amber-300 text-2xl w-[2rem] h-[2rem] p-1 items-center rounded-full">
                        <Icon className="text-amber-100 cursor-pointer" icon="oi:plus" />

                    </div>

                </div>
                <div className="grid grid-cols-5 justify-self-center gap-8 p-20">
                    {data.map(person => (
                            <div className="w-full cursor-pointer hover:scale-110" key={person.name}>
                                <Card className="w-full p-4 bg-amber-300 rounded-3xl text-neutral-600">
                                    <CardHeader className="pb-0 pt-2 px-4 flex-col items-center">
                                        <p className="text-tiny uppercase font-bold">{person.name}</p>
                                        <small className="text-neutral-600">{person.birth_year || "Desconocido"}</small>
                                        <small className="text-neutral-600">{person.gender || "Desconocido"}</small>
                                    </CardHeader>
                                    <CardBody className="overflow-visible py-2">
                                        <Image
                                            alt={`${person.name} image`}
                                            className="object-cover rounded-3xl"
                                            src={imagesSWAPI[person.name] || person.imgUrl}
                                            width={270}
                                            height={270}
                                        />
                                    </CardBody>
                                </Card>
                            </div>
                        ))}
                </div>
            </div>
        </>
    );
}