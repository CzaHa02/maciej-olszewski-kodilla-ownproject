package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Component
class TrelloMapperTest {

    @Test
    void shouldMapToBoards() {
        TrelloMapper trelloMapper = new TrelloMapper();

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("sulok1", "sdasd1", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("sulok2", "sdasd2", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("sulok3", "sdasd3", new ArrayList<>()));

        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        assertEquals(trelloBoards.size(), trelloBoardDtos.size());
        assertEquals(3, trelloBoards.size());
        assertEquals(3, trelloBoardDtos.size());
    }

    @Test
    void shouldMapToBoardsDto() {
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(new TrelloBoardDto("sulokDTO1", "sdasdDTO1", new ArrayList<>()));
        trelloBoardsDto.add(new TrelloBoardDto("sulokDTO2", "sdasdDTO2", new ArrayList<>()));
        trelloBoardsDto.add(new TrelloBoardDto("sulokDTO3", "sdasdDTO3", new ArrayList<>()));

        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoards(trelloBoardsDto);

        assertEquals(trelloBoardsDto.size(), trelloBoard.size());
        assertEquals(3, trelloBoardsDto.size());
        assertEquals(3, trelloBoard.size());

    }

    @Test
    void shouldMapToList() {
        TrelloMapper trelloMapper = new TrelloMapper();

        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("id 1", "Name1", false));
        trelloLists.add(new TrelloList("id 2", "Name2", false));
        trelloLists.add(new TrelloList("id 3", "Name3", false));

        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        assertEquals(trelloLists.size(), trelloListDtos.size());
        assertEquals(trelloLists.isEmpty(), false);


    }

    @Test
    void shouldMapToListDto() {
        TrelloMapper trelloMapper = new TrelloMapper();

        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("id 1", "Name1", false));
        trelloListsDto.add(new TrelloListDto("id 2", "Name2", false));
        trelloListsDto.add(new TrelloListDto("id 3", "Name3", false));

        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListsDto);

        assertEquals(trelloListsDto.size(), trelloList.size());
        assertEquals(trelloListsDto.isEmpty(), false);
    }

    @Test
    void shouldMapToCardDto() {
        TrelloMapper trelloMapper = new TrelloMapper();

        TrelloCardDto trelloCardDto = new TrelloCardDto("cardName", "cardDescription", "cardPos", "1");

        TrelloCard trelloCardMap = trelloMapper.mapToCard(trelloCardDto);

        assertEquals(trelloCardDto.getName(), trelloCardMap.getName());

    }

    @Test
    void shouldMapToCard() {
        TrelloMapper trelloMapper = new TrelloMapper();

        TrelloCard trelloCard = new TrelloCard("cardName", "cardDescription", "cardPos", "1");

        TrelloCardDto trelloCardDtoMap = trelloMapper.mapToCardDto(trelloCard);

        assertEquals(trelloCard.getName(), trelloCardDtoMap.getName());

    }
}